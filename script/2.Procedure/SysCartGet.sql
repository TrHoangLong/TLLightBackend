/****** Object:  StoredProcedure [dbo].[SysCartGet]    Script Date: 6/22/2023 7:40:52 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[SysCartGet]
GO

/****** Object:  StoredProcedure [dbo].[SysCartGet]    Script Date: 6/22/2023 7:40:52 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[SysCartGet]
	@SysUserId VARCHAR(30),
	@ProductId VARCHAR(20),
	@Status INT
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
	AND (sc.[Status] = @Status OR @Status = 0)
END
GO