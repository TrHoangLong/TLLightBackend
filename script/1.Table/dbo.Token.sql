/****** Object:  Table [dbo].[Token]    Script Date: 4/8/2023 10:54:31 PM ******/
DROP TABLE IF EXISTS [dbo].[Token]
    GO

/****** Object:  Table [dbo].[Token]    Script Date: 4/8/2023 10:54:31 PM ******/
    SET ANSI_NULLS ON
    GO

    SET QUOTED_IDENTIFIER ON
    GO

CREATE TABLE [dbo].[Token](
    [Token] [varchar](500) NOT NULL,
    PRIMARY KEY CLUSTERED
(
[Token] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO


