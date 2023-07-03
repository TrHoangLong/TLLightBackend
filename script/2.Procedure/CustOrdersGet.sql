/****** Object:  StoredProcedure [dbo].[CustOrdersGet]    Script Date: 7/1/2023 9:41:56 AM ******/
DROP PROCEDURE IF EXISTS [dbo].[CustOrdersGet]
GO

/****** Object:  StoredProcedure [dbo].[CustOrdersGet]    Script Date: 7/1/2023 9:41:56 AM ******/
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

    SELECT co.*, p.ProductName, cu.CustName FROM CustOrders co
	LEFT JOIN Product p ON p.ProductId = co.ProductId
	LEFT JOIN CustomerUser cu ON cu.CustUserId = co.CustUserId
	WHERE (co.ProductId = @ProductId OR @ProductId = '')
	AND (co.CustUserId = @CustUserId OR @CustUserId = '')
	AND (co.OrderStatus = @OrderStatus OR @OrderStatus = 0)

END
GO


