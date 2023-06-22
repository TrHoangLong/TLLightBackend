/****** Object:  StoredProcedure [dbo].[CustomerUserGet]    Script Date: 6/22/2023 7:29:28 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[CustomerUserGet]
GO

/****** Object:  StoredProcedure [dbo].[CustomerUserGet]    Script Date: 6/22/2023 7:29:28 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO


-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[CustomerUserGet]
	@CustUserId VARCHAR(30),
	@Status INT
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

	SELECT * FROM CustomerUser
	WHERE (CustUserId = @CustUserId OR @CustUserId =  '')
	AND ([Status] = @Status OR @Status = 0)

END
GO
