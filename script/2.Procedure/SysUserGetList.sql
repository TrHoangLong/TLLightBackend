/****** Object:  StoredProcedure [dbo].[SysUserGetList]    Script Date: 4/27/2023 10:58:27 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[SysUserGetList]
GO

/****** Object:  StoredProcedure [dbo].[SysUserGetList]    Script Date: 4/27/2023 10:58:27 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[SysUserGetList]
	@UserId VARCHAR(30),
	@Status INT
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT 
		SysUserId,
		UserName,
		[Role],
		[Status],
		Remarks
	FROM SysUser
	WHERE [Status] = @Status OR @Status = 0;
END
GO


