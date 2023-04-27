/****** Object:  StoredProcedure [dbo].[SysUserInsert]    Script Date: 4/27/2023 11:23:22 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[SysUserInsert]
GO

/****** Object:  StoredProcedure [dbo].[SysUserInsert]    Script Date: 4/27/2023 11:23:22 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO



CREATE PROCEDURE [dbo].[SysUserInsert] 
	@SysUserId VARCHAR(30),
	@Password VARCHAR(100),
	@UserName NVARCHAR(50),
	@Role INT,
	@Status INT,
	@Remarks VARCHAR(200)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    IF EXISTS (SELECT 1 FROM SysUser WHERE SysUserId = @SysUserId AND [Status] = 1 )
	BEGIN
		RAISERROR (N'Tài khoản đã tồn tại', 15, 1);
		RETURN;
	END

	INSERT INTO SysUser
	(
		SysUserId,
		[Password],
		UserName,
		[Role],
		[Status],
		Remarks
	)
	VALUES
	(
		@SysUserId,
		@Password,
		@UserName,
		@Role,
		@Status,
		@Remarks
	);

END
GO


