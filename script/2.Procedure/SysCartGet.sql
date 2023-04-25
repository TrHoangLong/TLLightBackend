/****** Object:  StoredProcedure [dbo].[SysCardGet]    Script Date: 4/24/2023 8:46:17 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[SysCardGet]
GO

/****** Object:  StoredProcedure [dbo].[SysCardGet]    Script Date: 4/24/2023 8:46:17 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO




CREATE PROCEDURE [dbo].[SysCardGet]
	@SysUserId VARCHAR(30),
	@ProductId VARCHAR(20)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

	SELECT 
		sc.*, 
		p.ProductName, 
		ISNULL((sc.ProductPrice * sc.Quantity), 0) AS ToalCart
	FROM SysCart sc
	LEFT JOIN Product p ON sc.ProductId = p.ProductId
	WHERE (sc.SysUserId = @SysUserId OR @SysUserId = '')
	AND (sc.ProductId = @ProductId OR @ProductId = '')
END
GO


