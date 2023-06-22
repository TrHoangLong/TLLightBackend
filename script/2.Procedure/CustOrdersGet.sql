/****** Object:  StoredProcedure [dbo].[CustOrdersGet]    Script Date: 6/22/2023 7:34:22 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[CustOrdersGet]
GO

/****** Object:  StoredProcedure [dbo].[CustOrdersGet]    Script Date: 6/22/2023 7:34:22 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[CustOrdersGet]
	@UserId VARCHAR(30),
	@ProductId VARCHAR(30),
	@CustUserId VARCHAR(30),
	@OrderStatus INT
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    SELECT co.*, p.ProductName FROM CustOrders co
	LEFT JOIN Product p ON p.ProductId = co.ProductId
	WHERE (co.ProductId = @ProductId OR @ProductId = '')
	AND (co.CustUserId = @CustUserId OR @CustUserId = '')
	AND (co.OrderStatus = @OrderStatus OR @OrderStatus = 0)

END
GO


