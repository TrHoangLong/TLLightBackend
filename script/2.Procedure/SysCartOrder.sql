/****** Object:  StoredProcedure [dbo].[SysCartOrder]    Script Date: 5/10/2023 9:46:21 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[SysCartOrder]
GO

/****** Object:  StoredProcedure [dbo].[SysCartOrder]    Script Date: 5/10/2023 9:46:21 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO




CREATE PROCEDURE [dbo].[SysCartOrder]
	@SysUserId VARCHAR(30),
	@CustName NVARCHAR(50),
	@MobileNo VARCHAR(13),
	@Address NVARCHAR(500),
	@ProductId VARCHAR(20),
	@Quantity DECIMAL(18,0),
	@ProductPrice DECIMAL(28,6),
	@IsSysOrder BIT,
	@SysCartId INT
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

	IF @IsSysOrder = 1 AND NOT EXISTS (SELECT 1 FROM SysCart WHERE SysCartId = @SysCartId AND Status = 1)
	BEGIN
		RAISERROR (N'Sản phẩm không có trong giỏ hàng', 15, 1);
		RETURN;
	END
	
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

	DECLARE @TotalPrice DECIMAL(28,6);
	SET @TotalPrice  = @Quantity * @ProductPrice;

	INSERT INTO [dbo].[SysOrders]
    (
		[SysOrderDate]
		,[SysUserId]
		,[OrderStatus]
		,[CustName]
		,[MobileNo]
		,[Address]
		,[ProductId]
		,[Quantity]
		,[ProductPrice]
		,[TotalPrice]
		,[UpdatedUserId]
		,[UpdatedTime]
	)
    VALUES
	(
		dbo.GetBusinessDate(),
		@SysUserId,
		1,
		@CustName,
		@MobileNo,
		@Address,
		@ProductId,
		@Quantity,
		@ProductPrice,
		@TotalPrice,
		@SysUserId,
		GETDATE()
	);

	UPDATE Product
	SET 
		Quantity = Quantity - @Quantity
	WHERE ProductId = @ProductId;

	IF @IsSysOrder = 1
	BEGIN
		UPDATE SysCart
		SET 
			[Status] = 2
		WHERE SysCartId = @SysCartId
	END

END
GO


