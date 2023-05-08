/****** Object:  StoredProcedure [dbo].[CustomerUserUpdate]    Script Date: 5/8/2023 9:25:41 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[CustomerUserUpdate]
GO

/****** Object:  StoredProcedure [dbo].[CustomerUserUpdate]    Script Date: 5/8/2023 9:25:41 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO



-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[CustomerUserUpdate]
	@UserId VARCHAR(30),
	@CustName NVARCHAR(50),
	@Gender INT,
	@Birthday DATE,
	@MobileNo VARCHAR(20),
	@Email VARCHAR(200),
	@Address NVARCHAR(500),
	@Remarks VARCHAR(200),
	@CustUserId VARCHAR(30)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

	DECLARE @OldEmail VARCHAR(200);
	DECLARE @OldMobileNo VARCHAR(20);

	SELECT @OldEmail = Email, @OldMobileNo = MobileNo FROM CustomerUser WHERE CustUserId = @CustUserId;

	IF @Email <> @OldEmail 
	BEGIN
		IF EXISTS (SELECT 1 FROM CustomerUser WHERE Email = @Email AND [Status] = 1)
		BEGIN
			RAISERROR(N'Email đã được đăng ký tài khoản', 15, 1);
			RETURN;
		END
	END
    
	IF @MobileNo <> @OldMobileNo
	BEGIN
		IF EXISTS (SELECT 1 FROM CustomerUser WHERE MobileNo = @MobileNo AND [Status] = 1)
		BEGIN
			RAISERROR(N'Số điện thoại đã được đăng ký tài khoản', 15, 1);
			RETURN;
		END
	END

	UPDATE CustomerUser
	SET
		CustName = @CustName,
		Gender = @Gender,
		Birthday = @Birthday,
		MobileNo = @MobileNo,
		Email = @Email,
		[Address] = @Address,
		Remarks = @Remarks
	WHERE CustUserId = @CustUserId
		
END
GO


