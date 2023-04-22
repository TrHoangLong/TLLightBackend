/****** Object:  StoredProcedure [dbo].[ProductUpdate]    Script Date: 4/22/2023 1:06:30 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[ProductUpdate]
GO

/****** Object:  StoredProcedure [dbo].[ProductUpdate]    Script Date: 4/22/2023 1:06:30 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO


-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[ProductUpdate] 
	@UserId VARCHAR(30),
	@ProductId VARCHAR(20),
	@CategoryId VARCHAR(20),
	@ProductName NVARCHAR(50),
	@ProductPrice DECIMAL(28,6),
	@Description NTEXT,
	@Quantity DECIMAL(18,0),
	@ProductImage VARCHAR(200),
	@Status INT
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    IF NOT EXISTS (SELECT 1 FROM Product WHERE ProductId = @ProductId)
	BEGIN
		RAISERROR (N'Sản phẩm chưa được khai báo', 15, 1);
		RETURN;
	END

	IF NOT EXISTS (SELECT 1 FROM ProductCategories WHERE CategoryId = @CategoryId)
	BEGIN
		RAISERROR (N'Loại sản phẩm không đúng', 15, 1);
		RETURN;
	END

	UPDATE [dbo].[Product]
	SET
		CategoryId = @CategoryId,
		ProductName = @ProductName,
		ProductPrice = @ProductPrice,
		Description = @Description,
		Quantity = @Quantity,
		ProductImage = (
			CASE 
				WHEN @ProductImage IS NULL THEN ProductImage
				ELSE @ProductImage
			END
		),
		Status = @Status,
		UpdatedUserId = @UserId,
		UpdatedTime = GETDATE()
	WHERE ProductId = @ProductId;

END
GO


