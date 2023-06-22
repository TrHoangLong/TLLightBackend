/****** Object:  StoredProcedure [dbo].[CustomerUserInsert]    Script Date: 6/22/2023 7:31:46 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[CustomerUserInsert]
GO

/****** Object:  StoredProcedure [dbo].[CustomerUserInsert]    Script Date: 6/22/2023 7:31:46 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[CustomerUserInsert]
	@UserId VARCHAR(30),
	@Password VARCHAR(200),
	@CustName NVARCHAR(50),
	@Gender INT,
	@Birthday DATE,
	@MobileNo VARCHAR(20),
	@Email VARCHAR(200),
	@Address NVARCHAR(500),
	@Remarks VARCHAR(200),
	@CustUserId VARCHAR(30) OUT
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;
	
	SET @CustUserId = dbo.RandomCustNo();
	SELECT * FROM CustomerUser WHERE CustUserId = @CustUserId
	WHILE @@ROWCOUNT <> 0 
	BEGIN
		SET @CustUserId = dbo.RandomCustNo();
		SELECT * FROM CustomerUser WHERE CustUserId = @CustUserId
	END

	IF EXISTS (SELECT 1 FROM CustomerUser WHERE Email = @Email AND [Status] = 1)
	BEGIN
		RAISERROR(N'Email đã được đăng ký tài khoản', 15, 1);
		RETURN;
	END

	IF EXISTS (SELECT 1 FROM CustomerUser WHERE MobileNo = @MobileNo AND [Status] = 1)
	BEGIN
		RAISERROR(N'Số điện thoại đã được đăng ký tài khoản', 15, 1);
		RETURN;
	END

	INSERT INTO [dbo].[CustomerUser]
    (
		[CustUserId]
		,[Password]
		,[CustName]
		,[Gender]
		,[Birthday]
		,[MobileNo]
		,[Email]
		,[Address]
		,[Status]
		,[Remarks]
	)
    VALUES
	(
		@CustUserId,
		@Password,
		@CustName,
		@Gender,
		@Birthday,
		@MobileNo,
		@Email,
		@Address,
		1,
		@Remarks
	);

END
GO


