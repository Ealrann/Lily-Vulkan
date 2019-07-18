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
	<T extends Presentation> DataProviderPkg<T> createDataProviderPkg();

	/**
	 * Returns a new object of class '<em>Generic Described Data Provider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Generic Described Data Provider</em>'.
	 * @generated
	 */
	<T extends Presentation> GenericDescribedDataProvider<T> createGenericDescribedDataProvider();

	/**
	 * Returns a new object of class '<em>Renderable Data Source</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Renderable Data Source</em>'.
	 * @generated
	 */
	<T extends Presentation> RenderableDataSource<T> createRenderableDataSource();

	/**
	 * Returns a new object of class '<em>Generic Vertex Provider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Generic Vertex Provider</em>'.
	 * @generated
	 */
	<T extends Presentation> GenericVertexProvider<T> createGenericVertexProvider();

	/**
	 * Returns a new object of class '<em>Generic Index Provider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Generic Index Provider</em>'.
	 * @generated
	 */
	<T extends Presentation> GenericIndexProvider<T> createGenericIndexProvider();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	RenderingPackage getRenderingPackage();

} //RenderingFactory
