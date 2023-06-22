/****** Object:  StoredProcedure [dbo].[ProductCategoriesInsert]    Script Date: 6/22/2023 7:37:17 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[ProductCategoriesInsert]
GO

/****** Object:  StoredProcedure [dbo].[ProductCategoriesInsert]    Script Date: 6/22/2023 7:37:17 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[ProductCategoriesInsert]
	@UserId VARCHAR(30),
	@CategoryId VARCHAR(20),
	@CategoryName NVARCHAR(50),
	@Status INT
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    IF EXISTS (SELECT 1 FROM ProductCategories WHERE CategoryId = @CategoryId)
BEGIN
		RAISERROR (N'Danh mục sản phẩm đã tồn tại', 15, 1);
		RETURN;
END

INSERT INTO [dbo].[ProductCategories]
(
    [CategoryId]
    ,[CategoryName]
    ,[Status]
    ,[CreatedUserId]
    ,[CreatedTime]
    ,[UpdatedUserId]
    ,[UpdatedTime]
)
VALUES
    (
    @CategoryId,
    @CategoryName,
    @Status,
    @UserId,
    GETDATE(),
    @UserId,
    GETDATE()
    );

END
GO


