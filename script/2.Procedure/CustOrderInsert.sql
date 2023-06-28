/****** Object:  StoredProcedure [dbo].[CustOrderInsert]    Script Date: 6/28/2023 9:23:55 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[CustOrderInsert]
GO

/****** Object:  StoredProcedure [dbo].[CustOrderInsert]    Script Date: 6/28/2023 9:23:55 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO



CREATE PROCEDURE [dbo].[CustOrderInsert]
	@UserId VARCHAR(30),
	@ProductId VARCHAR(30),
	@Quantity DECIMAL(18,0),
	@MobileNo VARCHAR(20),
	@Address NVARCHAR(500),
	@IsCustCartOrder BIT,
	@CustCartId INT
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    DECLARE @ProductQty DECIMAL(18,0);
	DECLARE @ProductPrice DECIMAL(18,6);

	SELECT 
		@ProductQty = Quantity,
		@ProductPrice = ProductPrice
	FROM Product
	WHERE ProductId = @ProductId;

	IF @Quantity > @ProductQty
	BEGIN
		RAISERROR(N'Số lượng sản phẩm còn lại không đủ', 15, 1)
		RETURN;
	END

	IF @IsCustCartOrder = 1 AND NOT EXISTS (SELECT 1 FROM CustCart WHERE CustCartId = @CustCartId)
	BEGIN
		RAISERROR(N'Sản phẩm không có trong giỏ hàng', 15, 1)
		RETURN;
	END

	DECLARE @TotalPrice DECIMAL(28,6);
	SET @TotalPrice  = @Quantity * @ProductPrice;

	INSERT INTO [dbo].[CustOrders]
    (
		[CustOrderDate]
		,[OrderStatus]
		,[CustUserId]
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
		1,
		@UserId,
		@MobileNo,
		@Address,
		@ProductId,
		@Quantity,
		@ProductPrice,
		@TotalPrice,
		@UserId,
		GETDATE()
	);

	UPDATE Product
	SET	
		Quantity = Quantity - @Quantity
	WHERE ProductId = @ProductId

	IF @IsCustCartOrder = 1
	BEGIN
		UPDATE CustCart
		SET 
			[Status] = 2
		WHERE CustCartId = @CustCartId
	END

END
GO


