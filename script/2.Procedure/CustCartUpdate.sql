/****** Object:  StoredProcedure [dbo].[CustCartUpdate]    Script Date: 6/22/2023 7:28:56 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[CustCartUpdate]
GO

/****** Object:  StoredProcedure [dbo].[CustCartUpdate]    Script Date: 6/22/2023 7:28:56 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO



CREATE PROCEDURE [dbo].[CustCartUpdate]
	@UserId VARCHAR(30),
	@CustCartId INT,
	@Quantity DECIMAL(18,0)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

	DECLARE @ProductId VARCHAR(30);
	DECLARE @ProductQty  DECIMAL(18,0);

	SELECT 
		@ProductId = ProductId 
	FROM CustCart WHERE CustCartId = @CustCartId;

	SELECT 
		@ProductQty = Quantity
	FROM Product
	WHERE ProductId = @ProductId 
	AND [Status] = 1

	IF @Quantity > @ProductQty
	BEGIN
		RAISERROR(N'Số lượng sản phẩm không đủ', 15, 1);
		RETURN;
	END

	UPDATE CustCart
	SET Quantity = @Quantity
	WHERE CustCartId = @CustCartId

END
GO


