/****** Object:  StoredProcedure [dbo].[SysCartUpdate]    Script Date: 6/22/2023 7:41:32 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[SysCartUpdate]
GO

/****** Object:  StoredProcedure [dbo].[SysCartUpdate]    Script Date: 6/22/2023 7:41:32 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO





CREATE PROCEDURE [dbo].[SysCartUpdate]
	@SysCardId INT,
	@SysUserId VARCHAR(30),
	@ProductId VARCHAR(20),
	@Quantity INT,
	@ProductPrice DECIMAL(28,6)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

	IF NOT EXISTS (SELECT 1 FROM Product WHERE ProductId = @ProductId AND [status] = 1)
	BEGIN
		RAISERROR (N'Sản phẩm không tồn tại hoặc đang đóng', 15, 1);
		RETURN;
	END

	DECLARE @RemainQty INT;
	DECLARE @Price DECIMAL(28,6);
	SELECT @RemainQty = Quantity, @Price = ProductPrice FROM Product WHERE ProductId = @ProductId;

	IF @Quantity > @RemainQty
	BEGIN
		RAISERROR (N'Số lượng sản phẩm còn lại không đủ', 15, 1);
		RETURN;
	END

	IF @ProductPrice <> @Price
	BEGIN
		RAISERROR (N'Giá sản phẩm đang sai', 15, 1);
		RETURN;
	END

	UPDATE SysCart
	SET
		SysUserId = @SysUserId,
		ProductId = @ProductId,
		Quantity = @Quantity,
		ProductPrice = @ProductPrice
	WHERE SysCartId = @SysCardId
END
GO


