/****** Object:  StoredProcedure [dbo].[SysUserDelete]    Script Date: 6/22/2023 7:44:08 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[SysUserDelete]
GO

/****** Object:  StoredProcedure [dbo].[SysUserDelete]    Script Date: 6/22/2023 7:44:08 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[SysUserDelete] 
	@SysUserId VARCHAR(30)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    IF NOT EXISTS (SELECT 1 FROM SysUser WHERE SysUserId = @SysUserId AND [Status] = 1 )
	BEGIN
		RAISERROR (N'Tài khoản không tồn tại', 15, 1);
		RETURN;
	END

	UPDATE SysUser
	SET 
		[Status] = 2
	WHERE SysUserId = @SysUserId;
END
GO


