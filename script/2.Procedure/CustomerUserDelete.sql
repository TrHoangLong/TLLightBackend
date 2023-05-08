/****** Object:  StoredProcedure [dbo].[CustomerUserDelete]    Script Date: 5/6/2023 2:53:20 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[CustomerUserDelete]
GO

/****** Object:  StoredProcedure [dbo].[CustomerUserDelete]    Script Date: 5/6/2023 2:53:20 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO


-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[CustomerUserDelete]
	@UserId VARCHAR(30),
	@CustUserId VARCHAR(30)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    UPDATE CustomerUser
	SET
		[Status] = 2
	WHERE CustUserId = @CustUserId;

END
GO


