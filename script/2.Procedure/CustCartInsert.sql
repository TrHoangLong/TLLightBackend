/****** Object:  StoredProcedure [dbo].[CustCartInsert]    Script Date: 6/22/2023 7:28:18 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[CustCartInsert]
GO

/****** Object:  StoredProcedure [dbo].[CustCartInsert]    Script Date: 6/22/2023 7:28:18 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO



CREATE PROCEDURE [dbo].[CustCartInsert]
	@UserId VARCHAR(30),
	@ProductId VARCHAR(30),
	@Quantity DECIMAL(18,0)
AS
BEGIN
	
	SET NOCOUNT ON;

	DECLARE @ProductPrice DECIMAL(18,6);
	DECLARE @ProductQty DECIMAL(18,0);

	SELECT 
		@ProductPrice = ProductPrice,
		@ProductQty = Quantity
	FROM Product
	WHERE ProductId = @ProductId 
	AND [Status] = 1

	IF @@ROWCOUNT = 0
	BEGIN
		RAISERROR(N'Sản phẩm không tồn tại', 15, 1);
		RETURN;
	END

	IF @Quantity > @ProductQty
	BEGIN
		RAISERROR(N'Số lượng sản phẩm không đủ', 15, 1);
		RETURN;
	END

	IF NOT EXISTS (SELECT 1 FROM CustCart WHERE CustUserId = @UserId AND ProductId = @ProductId AND [Status] = 1)
	BEGIN
		INSERT INTO [dbo].[CustCart]
		(
			[CustUserId]
			,[ProductId]
			,[Quantity]
			,[ProductPrice]
			,[Status]
		)
		VALUES
		(
			@UserId,
			@ProductId,
			@Quantity,
			@ProductPrice,
			1
		);
	END
	ELSE
	BEGIN
		UPDATE CustCart
		SET 
			Quantity = Quantity + @Quantity
		WHERE CustUserId = @UserId AND ProductId = @ProductId AND [Status] = 1
	END

END
GO


