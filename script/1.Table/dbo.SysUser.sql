/****** Object:  Table [dbo].[SysUser]    Script Date: 6/22/2023 7:16:16 PM ******/
DROP TABLE IF EXISTS [dbo].[SysUser]
GO

/****** Object:  Table [dbo].[SysUser]    Script Date: 6/22/2023 7:16:16 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[SysUser](
	[SysUserId] [varchar](30) NOT NULL,
	[Password] [varchar](100) NOT NULL,
	[UserName] [nvarchar](50) NOT NULL,
	[Role] [int] NOT NULL,
	[Status] [int] NOT NULL,
	[Remarks] [varchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[SysUserId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO


