IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[SysCart]') AND type in (N'U'))
ALTER TABLE [dbo].[SysCart] DROP CONSTRAINT IF EXISTS [FK__SysCart__SysUser__731B1205]
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[SysCart]') AND type in (N'U'))
ALTER TABLE [dbo].[SysCart] DROP CONSTRAINT IF EXISTS [FK__SysCart__Product__7226EDCC]
GO

/****** Object:  Table [dbo].[SysCart]    Script Date: 6/22/2023 7:14:31 PM ******/
DROP TABLE IF EXISTS [dbo].[SysCart]
GO

/****** Object:  Table [dbo].[SysCart]    Script Date: 6/22/2023 7:14:31 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[SysCart](
	[SysCartId] [int] IDENTITY(1,1) NOT NULL,
	[SysUserId] [varchar](30) NOT NULL,
	[ProductId] [varchar](20) NOT NULL,
	[Quantity] [decimal](18, 0) NOT NULL,
	[ProductPrice] [decimal](28, 6) NOT NULL,
	[Status] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[SysCartId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[SysCart]  WITH CHECK ADD FOREIGN KEY([ProductId])
REFERENCES [dbo].[Product] ([ProductId])
GO

ALTER TABLE [dbo].[SysCart]  WITH CHECK ADD FOREIGN KEY([SysUserId])
REFERENCES [dbo].[SysUser] ([SysUserId])
GO


