/****** Object:  StoredProcedure [dbo].[ProductCategoriesUpdate]    Script Date: 6/22/2023 7:38:28 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[ProductCategoriesUpdate]
GO

/****** Object:  StoredProcedure [dbo].[ProductCategoriesUpdate]    Script Date: 6/22/2023 7:38:28 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO


-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[ProductCategoriesUpdate]
	@UserId VARCHAR(30),
	@CategoryId VARCHAR(20),
	@CategoryName NVARCHAR(50),
	@Status INT
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

	IF NOT EXISTS (SELECT 1 FROM ProductCategories WHERE CategoryId = @CategoryId)
	BEGIN
		RAISERROR (N'Danh mục sản phẩm không tồn tại', 15, 1);
		RETURN;
	END

	UPDATE ProductCategories
	SET
		CategoryName = @CategoryName,
		[Status] = @Status,
		UpdatedUserId = @UserId, 
		UpdatedTime = GETDATE()
	WHERE CategoryId = @CategoryId;
END
GO


