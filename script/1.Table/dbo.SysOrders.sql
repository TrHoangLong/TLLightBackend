IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[SysOrders]') AND type in (N'U'))
ALTER TABLE [dbo].[SysOrders] DROP CONSTRAINT IF EXISTS [FK__SysOrders__SysUs__6D6238AF]
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[SysOrders]') AND type in (N'U'))
ALTER TABLE [dbo].[SysOrders] DROP CONSTRAINT IF EXISTS [FK__SysOrders__SysUs__6C6E1476]
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[SysOrders]') AND type in (N'U'))
ALTER TABLE [dbo].[SysOrders] DROP CONSTRAINT IF EXISTS [FK__SysOrders__Produ__6B79F03D]
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[SysOrders]') AND type in (N'U'))
ALTER TABLE [dbo].[SysOrders] DROP CONSTRAINT IF EXISTS [FK__SysOrders__Produ__6A85CC04]
GO

/****** Object:  Table [dbo].[SysOrders]    Script Date: 6/22/2023 7:15:01 PM ******/
DROP TABLE IF EXISTS [dbo].[SysOrders]
GO

/****** Object:  Table [dbo].[SysOrders]    Script Date: 6/22/2023 7:15:01 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[SysOrders](
	[SysOrderDate] [smalldatetime] NOT NULL,
	[SysOrderId] [int] IDENTITY(1,1) NOT NULL,
	[SysUserId] [varchar](30) NULL,
	[OrderStatus] [int] NOT NULL,
	[CustName] [nvarchar](50) NOT NULL,
	[MobileNo] [varchar](13) NOT NULL,
	[Address] [nvarchar](500) NOT NULL,
	[ProductId] [varchar](20) NOT NULL,
	[Quantity] [decimal](18, 0) NOT NULL,
	[ProductPrice] [decimal](28, 6) NOT NULL,
	[TotalPrice] [decimal](28, 6) NOT NULL,
	[UpdatedUserId] [varchar](30) NULL,
	[UpdatedTime] [datetime2](7) NULL,
PRIMARY KEY CLUSTERED 
(
	[SysOrderDate] ASC,
	[SysOrderId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[SysOrders]  WITH CHECK ADD FOREIGN KEY([ProductId])
REFERENCES [dbo].[Product] ([ProductId])
GO

ALTER TABLE [dbo].[SysOrders]  WITH CHECK ADD FOREIGN KEY([ProductId])
REFERENCES [dbo].[Product] ([ProductId])
GO

ALTER TABLE [dbo].[SysOrders]  WITH CHECK ADD FOREIGN KEY([SysUserId])
REFERENCES [dbo].[SysUser] ([SysUserId])
GO

ALTER TABLE [dbo].[SysOrders]  WITH CHECK ADD FOREIGN KEY([SysUserId])
REFERENCES [dbo].[SysUser] ([SysUserId])
GO


