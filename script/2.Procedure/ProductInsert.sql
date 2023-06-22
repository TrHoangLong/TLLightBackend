/****** Object:  StoredProcedure [dbo].[ProductInsert]    Script Date: 6/22/2023 7:39:43 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[ProductInsert]
GO

/****** Object:  StoredProcedure [dbo].[ProductInsert]    Script Date: 6/22/2023 7:39:43 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO



-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[ProductInsert] 
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

	IF EXISTS (SELECT 1 FROM Product WHERE ProductId = @ProductId)
	BEGIN
		RAISERROR (N'Sản phẩm đã được khai báo', 15, 1);
		RETURN;
	END

	IF NOT EXISTS (SELECT 1 FROM ProductCategories WHERE CategoryId = @CategoryId AND [Status] = 1)
	BEGIN
		RAISERROR (N'Loại sản phẩm không đúng hoặc đang đóng', 15, 1);
		RETURN;
	END

    -- Insert statements for procedure here
	INSERT INTO [dbo].[Product]
    (
		[ProductId]
		,[CategoryId]
		,[ProductName]
		,[ProductPrice]
		,[Description]
		,[Quantity]
		,[ProductImage]
		,[Status]
		,[CreatedUserId]
		,[CreatedTime]
		,[UpdatedUserId]
		,[UpdatedTime]
	)
     VALUES
	 (
		@ProductId,
		@CategoryId,
		@ProductName,
		@ProductPrice,
		@Description,
		@Quantity,
		@ProductImage,
		@Status,
		@UserId,
		GETDATE(),
		@UserId,
		GETDATE()
	 );
END
GO


