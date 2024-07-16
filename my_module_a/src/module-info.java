module my_module_a {
	exports pack1;
	exports pack2;
	requires  my_module_b; //빌드패스에서 모듈b 지워서 오류. 빌드패스>프로젝트>모듈b를 Add
}