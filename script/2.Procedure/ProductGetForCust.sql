/****** Object:  StoredProcedure [dbo].[ProductGetForCust]    Script Date: 6/22/2023 7:39:25 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[ProductGetForCust]
GO

/****** Object:  StoredProcedure [dbo].[ProductGetForCust]    Script Date: 6/22/2023 7:39:25 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO




CREATE PROCEDURE [dbo].[ProductGetForCust] 
	@UserId VARCHAR(30),
	@ProductId VARCHAR(50),
	@CategoryId VARCHAR(200),
	
	@Offset INT,
	@Limit INT
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    IF @Limit > 0
	BEGIN
		SELECT 
			p.*, 
			pc.CategoryName,
			(CASE
				WHEN p.Quantity > 0 THEN N'Còn hàng'
				ELSE N'Hết hàng'
			END) AS QuantityStatus,
			COUNT(1) OVER() AS TotalRows
		FROM Product p
		LEFT JOIN ProductCategories pc ON pc.CategoryId = p.CategoryId
		WHERE p.Status = 1
		AND (p.ProductId = @ProductId OR @ProductId = '')
		AND (p.CategoryId = @CategoryId OR @CategoryId = '')
		ORDER BY p.ProductId ASC
		OFFSET @Offset ROWS FETCH NEXT @Limit ROWS ONLY;
		;
	END
	ELSE
	BEGIN
		SELECT 
			p.*, 
			pc.CategoryName,
			(CASE
				WHEN p.Quantity > 0 THEN N'Còn hàng'
				ELSE N'Hết hàng'
			END) AS QuantityStatus
		FROM Product p
		LEFT JOIN ProductCategories pc ON pc.CategoryId = p.CategoryId
		WHERE p.Status = 1
		AND (p.ProductId = @ProductId OR @ProductId = '')
		AND (p.CategoryId = @CategoryId OR @CategoryId = '')
		ORDER BY p.ProductId ASC
	END

END
GO


