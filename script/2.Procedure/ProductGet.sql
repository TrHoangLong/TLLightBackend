/****** Object:  StoredProcedure [dbo].[ProductGet]    Script Date: 4/21/2023 7:32:08 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[ProductGet]
    GO

/****** Object:  StoredProcedure [dbo].[ProductGet]    Script Date: 4/21/2023 7:32:08 PM ******/
    SET ANSI_NULLS ON
    GO

    SET QUOTED_IDENTIFIER ON
    GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[ProductGet]
	@ProductId VARCHAR(20),
	@CategoryId VARCHAR(20),
	@Status INT
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
SELECT p.*, pc.CategoryName FROM Product p
                                     LEFT JOIN ProductCategories pc ON pc.CategoryId = p.CategoryId
WHERE (p.ProductId = @ProductId OR @ProductId = '')
  AND (p.CategoryId = @CategoryId OR @CategoryId = '')
  AND (p.Status = @Status OR @Status = 0);
END
GO


