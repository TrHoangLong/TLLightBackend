/****** Object:  StoredProcedure [dbo].[SystemCloseDate]    Script Date: 6/22/2023 7:43:57 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[SystemCloseDate]
GO

/****** Object:  StoredProcedure [dbo].[SystemCloseDate]    Script Date: 6/22/2023 7:43:57 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO




-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[SystemCloseDate]
	@UserId VARCHAR(30)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

	--Đơn hàng của khách hàng
	INSERT INTO CustOrdersHist
	SELECT * FROM CustOrders
	WHERE OrderStatus IN (3, 9)

	DELETE FROM CustOrders
	WHERE OrderStatus IN (3, 9)
	
	--Đơn hàng của tài khoản nhân viên
	INSERT INTO SysOrdersHist
	SELECT * FROM SysOrders
	WHERE OrderStatus IN (3, 9)
	
	DELETE FROM SysOrders
	WHERE OrderStatus IN (3, 9)

END
GO


