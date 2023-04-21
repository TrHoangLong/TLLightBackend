/****** Object:  StoredProcedure [dbo].[ProductCategoriesGet]    Script Date: 4/10/2023 9:08:40 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[ProductCategoriesGet]
    GO

/****** Object:  StoredProcedure [dbo].[ProductCategoriesGet]    Script Date: 4/10/2023 9:08:40 PM ******/
    SET ANSI_NULLS ON
    GO

    SET QUOTED_IDENTIFIER ON
    GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[ProductCategoriesGet]
	@UserId VARCHAR(30),
	@CategoryId VARCHAR(20),
	@Status INT
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

SELECT * FROM ProductCategories
WHERE (CategoryId = @CategoryId OR @CategoryId = '')
  AND ([Status] = @Status OR @Status = 0);
END
GO


