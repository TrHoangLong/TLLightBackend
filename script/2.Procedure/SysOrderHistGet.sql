/****** Object:  StoredProcedure [dbo].[SysOrderHistGet]    Script Date: 5/9/2023 8:50:17 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[SysOrderHistGet]
GO

/****** Object:  StoredProcedure [dbo].[SysOrderHistGet]    Script Date: 5/9/2023 8:50:17 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO



-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[SysOrderHistGet]
	@SysUserId VARCHAR(30),
	@SysOrderDate SMALLDATETIME,
	@ProductId VARCHAR(20),
	@OrderStatus INT
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

	SELECT so.*, p.ProductName FROM SysOrdersHist so
	LEFT JOIN Product p ON p.ProductId = so.ProductId
	WHERE (so.SysUserId = @SysUserId OR @SysUserId = '')
	AND (so.ProductId = @ProductId OR @ProductId = '')
	AND (so.OrderStatus = @OrderStatus OR @OrderStatus = 0)
	AND(SysOrderDate = @SysOrderDate OR @SysOrderDate IS NULL)
END
GO


