/****** Object:  StoredProcedure [dbo].[CustomerUserRegister]    Script Date: 6/22/2023 7:32:14 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[CustomerUserRegister]
GO

/****** Object:  StoredProcedure [dbo].[CustomerUserRegister]    Script Date: 6/22/2023 7:32:14 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO



-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[CustomerUserRegister]
	@Password VARCHAR(100),
	@UserName NVARCHAR(50),
	@Gender INT,
	@Birthday DATE,
	@MobileNo VARCHAR(13),
	@Email VARCHAR(50),
	@Address NVARCHAR(500),
	@Status INT,
	@Remarks VARCHAR(200)
AS
BEGIN
	
	SET NOCOUNT ON;

    

END
GO


