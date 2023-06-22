/****** Object:  StoredProcedure [dbo].[ProductGet]    Script Date: 6/22/2023 7:38:52 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[ProductGet]
GO

/****** Object:  StoredProcedure [dbo].[ProductGet]    Script Date: 6/22/2023 7:38:52 PM ******/
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
	@Status INT,

	@Offset INT,
	@Limit INT
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here

	IF @Limit > 0
	BEGIN
		SELECT 
			p.*, 
			pc.CategoryName,
			COUNT(1) OVER() AS TotalRows
		FROM Product p
		LEFT JOIN ProductCategories pc ON pc.CategoryId = p.CategoryId
		WHERE (p.ProductId = @ProductId OR @ProductId = '')
		AND (p.CategoryId = @CategoryId OR @CategoryId = '')
		AND (p.Status = @Status OR @Status = 0)
		ORDER BY p.ProductId ASC
		OFFSET @Offset ROWS FETCH NEXT @Limit ROWS ONLY;
		;
	END
	ELSE
	BEGIN
		SELECT p.*, pc.CategoryName FROM Product p
		LEFT JOIN ProductCategories pc ON pc.CategoryId = p.CategoryId
		WHERE (p.ProductId = @ProductId OR @ProductId = '')
		AND (p.CategoryId = @CategoryId OR @CategoryId = '')
		AND (p.Status = @Status OR @Status = 0)
		ORDER BY p.ProductId ASC
	END
	
END
GO


