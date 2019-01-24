aws cloudformation create-stack \
	--profile masterdatadev \
	--stack-name formapi \
	--template-body file://cloudformation.yaml \
	--capabilities CAPABILITY_AUTO_EXPAND
