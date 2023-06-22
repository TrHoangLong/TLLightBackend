/****** Object:  StoredProcedure [dbo].[SysUserGetByUserId]    Script Date: 6/22/2023 7:44:19 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[SysUserGetByUserId]
GO

/****** Object:  StoredProcedure [dbo].[SysUserGetByUserId]    Script Date: 6/22/2023 7:44:19 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[SysUserGetByUserId]
	@SysUserId VARCHAR(30)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT * FROM SysUser WHERE SysUserId = @SysUserId AND [Status] = 1;
END
GO


