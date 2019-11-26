/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage
 * @generated
 */
public interface RenderingFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RenderingFactory eINSTANCE = org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Axis</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Axis</em>'.
	 * @generated
	 */
	Axis createAxis();

	/**
	 * Returns a new object of class '<em>Presentation Pkg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Presentation Pkg</em>'.
	 * @generated
	 */
	PresentationPkg createPresentationPkg();

	/**
	 * Returns a new object of class '<em>Presentable Entity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Presentable Entity</em>'.
	 * @generated
	 */
	PresentableEntity createPresentableEntity();

	/**
	 * Returns a new object of class '<em>Data Provider Pkg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Provider Pkg</em>'.
	 * @generated
	 */
	<T extends Structure> DataProviderPkg<T> createDataProviderPkg();

	/**
	 * Returns a new object of class '<em>Renderable Data Source</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Renderable Data Source</em>'.
	 * @generated
	 */
	<T extends Structure> RenderableDataSource<T> createRenderableDataSource();

	/**
	 * Returns a new object of class '<em>Vertex Provider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Vertex Provider</em>'.
	 * @generated
	 */
	<T extends Structure> VertexProvider<T> createVertexProvider();

	/**
	 * Returns a new object of class '<em>Index Provider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Index Provider</em>'.
	 * @generated
	 */
	<T extends Structure> IndexProvider<T> createIndexProvider();

	/**
	 * Returns a new object of class '<em>Static Resource Provider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Static Resource Provider</em>'.
	 * @generated
	 */
	StaticResourceProvider createStaticResourceProvider();

	/**
	 * Returns a new object of class '<em>Composite Resource Provider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite Resource Provider</em>'.
	 * @generated
	 */
	CompositeResourceProvider createCompositeResourceProvider();

	/**
	 * Returns a new object of class '<em>Render Proxy Constant Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Render Proxy Constant Buffer</em>'.
	 * @generated
	 */
	RenderProxyConstantBuffer createRenderProxyConstantBuffer();

	/**
	 * Returns a new object of class '<em>ISpecialization</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ISpecialization</em>'.
	 * @generated
	 */
	ISpecialization createISpecialization();

	/**
	 * Returns a new object of class '<em>Render Draw Task</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Render Draw Task</em>'.
	 * @generated
	 */
	RenderDrawTask createRenderDrawTask();

	/**
	 * Returns a new object of class '<em>Render Indexed Draw Task</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Render Indexed Draw Task</em>'.
	 * @generated
	 */
	RenderIndexedDrawTask createRenderIndexedDrawTask();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	RenderingPackage getRenderingPackage();

} //RenderingFactory
