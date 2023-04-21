/****** Object:  StoredProcedure [dbo].[TokenInsert]    Script Date: 4/10/2023 9:09:57 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[TokenInsert]
    GO

/****** Object:  StoredProcedure [dbo].[TokenInsert]    Script Date: 4/10/2023 9:09:57 PM ******/
    SET ANSI_NULLS ON
    GO

    SET QUOTED_IDENTIFIER ON
    GO




CREATE PROCEDURE [dbo].[TokenInsert]
	@Token VARCHAR(500)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
INSERT INTO Token
(
    Token
)
VALUES
    (
        @Token
    );
END
GO


