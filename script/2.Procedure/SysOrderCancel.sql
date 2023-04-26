/****** Object:  StoredProcedure [dbo].[SysOrderCancel]   Script Date: 4/26/2023 10:02:04 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[SysOrderCancel]
GO

/****** Object:  StoredProcedure [dbo].[SysOrderCancel]    Script Date: 4/26/2023 10:02:04 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[SysOrderCancel]
	@SysUserId VARCHAR(30),
	@SysOrderDate SMALLDATETIME,
	@SysOrderId INT
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

	UPDATE SysOrders
	SET 
		OrderStatus = 9,
		UpdatedUserId = @SysUserId,
		UpdatedTime = GETDATE()
	WHERE SysOrderDate = @SysOrderDate AND SysOrderId = @SysOrderId
	;

END
GO


