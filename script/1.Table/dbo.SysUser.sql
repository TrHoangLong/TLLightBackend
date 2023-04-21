/****** Object:  Table [dbo].[SysUser]    Script Date: 4/8/2023 10:57:09 PM ******/
DROP TABLE IF EXISTS [dbo].[SysUser]
    GO

/****** Object:  Table [dbo].[SysUser]    Script Date: 4/8/2023 10:57:09 PM ******/
    SET ANSI_NULLS ON
    GO

    SET QUOTED_IDENTIFIER ON
    GO

CREATE TABLE [dbo].[SysUser](
    [SysUserId] [varchar](30) NOT NULL,
    [Password] [varchar](100) NOT NULL,
    [UserName] [nvarchar](50) NOT NULL,
    [Gender] [int] NOT NULL,
    [Birthday] [date] NOT NULL,
    [MobileNo] [varchar](13) NOT NULL,
    [Email] [varchar](50) NOT NULL,
    [Address] [nvarchar](500) NOT NULL,
    [Status] [int] NOT NULL,
    [Remarks] [varchar](200) NULL,
    PRIMARY KEY CLUSTERED
(
[SysUserId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO


