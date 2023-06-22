/****** Object:  StoredProcedure [dbo].[SysOrderUpdateOrderStatus]    Script Date: 6/22/2023 7:43:43 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[SysOrderUpdateOrderStatus]
GO

/****** Object:  StoredProcedure [dbo].[SysOrderUpdateOrderStatus]    Script Date: 6/22/2023 7:43:43 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO



-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[SysOrderUpdateOrderStatus]
	@SysUserId VARCHAR(30),
	@SysOrderDate SMALLDATETIME,
	@SysOrderId INT,
	@OrderStatus INT
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

	IF @OrderStatus = 9
	BEGIN
		RAISERROR (N'Hủy đơn hàng không xử lý ở đây', 15, 1);
		RETURN;
	END

	UPDATE SysOrders
	SET 
		OrderStatus = @OrderStatus,
		UpdatedUserId = @SysUserId,
		UpdatedTime = GETDATE()
	WHERE SysOrderDate = @SysOrderDate AND SysOrderId = @SysOrderId
	;

END
GO


