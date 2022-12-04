# BsLayout Vaadin Addon

Vaadin Java integration of the responsive Bootstrap 4 layout. Based on **layout** package of the [lit-element-bootstrap](https://github.com/nik-christou/lit-element-bootstrap/tree/master/packages/layout) project.

## Demo project
[https://github.com/yuri0x7c1/bs-addon-demo](https://github.com/yuri0x7c1/bs-addon-demo)

## Usage examples
	// basic usage
	BsLayout layout = new BsLayout();
	BsRow row = layout.addRow();
	BsColumn col1 = row.addColumn(new BsColumn(new Label("Column 1-1")));
	col1.addSize(Size.MD, 3);
	BsColumn col2 = row.addColumn(new BsColumn(new Label("Column 1-2")));
	col2.addSize(Size.MD, 3);
	BsColumn col3 = row.addColumn(new BsColumn(new Label("Column 1-3")));
	col3.addSize(Size.MD, 3);
	col3.addOffset(Offset.MD, 3);

	// fluent api
	BsLayout layout = new BsLayout().withRows(
		new BsRow().withColumns(
			new BsColumn(new Label("Column 1-1")).withSize(Size.MD, 6),
			new BsColumn(new Label("Column 1-2")).withSize(Size.MD, 3),
			new BsColumn(new Label("Column 1-3")).withSize(Size.MD, 3)
		),
		new BsRow().withColumn(
			new BsColumn(new Label("Column 2-1"))
				.withSize(Size.MD, 6)
				.withOffset(Offset.MD, 6)
		)
	);

	// default column sizes
	BsLayout layout = new BsLayout().withDefaultSizes(12, 4, 4, 3, 2).withRow(
		new BsRow().withColumns(
			new BsColumn(new Label("Column 1-1")),
			new BsColumn(new Label("Column 1-2")),
			new BsColumn(new Label("Column 1-3"))
		)
	);

	// reordering columns
	BsLayout layout = new BsLayout(
		new BsRow(
			new BsColumn(new Label("1-st, but 3-rd on mobile"))
				.withOrder(Order.XS, 3)
				.withOrder(Order.SM, 1),
			new BsColumn(new Label("2-nd"))
				.withOrder(Order.XS, 2)
				.withOrder(Order.SM, 2),
			new BsColumn(new Label("3-rd, but 1-st on mobile"))
				.withOrder(Order.XS, 1)
				.withOrder(Order.SM, 3)
		)
	)
	.withDefaultSize(Size.XS);
