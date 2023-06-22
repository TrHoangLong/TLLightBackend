/****** Object:  StoredProcedure [dbo].[SysOrderGet]    Script Date: 6/22/2023 7:42:46 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[SysOrderGet]
GO

/****** Object:  StoredProcedure [dbo].[SysOrderGet]    Script Date: 6/22/2023 7:42:46 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO


-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[SysOrderGet]
	@SysUserId VARCHAR(30),
	@ProductId VARCHAR(20),
	@OrderStatus INT
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

	SELECT so.*, p.ProductName FROM SysOrders so
	LEFT JOIN Product p ON p.ProductId = so.ProductId
	WHERE (so.SysUserId = @SysUserId OR @SysUserId = '')
	AND (so.ProductId = @ProductId OR @ProductId = '')
	AND (so.OrderStatus = @OrderStatus OR @OrderStatus = 0)
END
GO


