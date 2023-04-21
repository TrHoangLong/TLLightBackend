/****** Object:  StoredProcedure [dbo].[SysUserInsert]    Script Date: 4/10/2023 9:09:24 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[SysUserInsert]
    GO

/****** Object:  StoredProcedure [dbo].[SysUserInsert]    Script Date: 4/10/2023 9:09:24 PM ******/
    SET ANSI_NULLS ON
    GO

    SET QUOTED_IDENTIFIER ON
    GO



CREATE PROCEDURE [dbo].[SysUserInsert]
	@SysUserId VARCHAR(30),
	@Password VARCHAR(100),
	@UserName NVARCHAR(50),
	@Gender INT,
	@Birthday DATE,
	@MobileNo VARCHAR(13),
	@Email NVARCHAR(50),
	@Address NVARCHAR(500),
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
    Gender,
    Birthday,
    MobileNo,
    Email,
    [Address],
    [Status],
    Remarks
)
VALUES
    (
        @SysUserId,
        @Password,
        @UserName,
        @Gender,
        @Birthday,
        @MobileNo,
        @Email,
        @Address,
        @Status,
        @Remarks
    );

END
GO


