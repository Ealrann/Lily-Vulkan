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
	 * Returns a new object of class '<em>Structure Pkg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Structure Pkg</em>'.
	 * @generated
	 */
	StructurePkg createStructurePkg();

	/**
	 * Returns a new object of class '<em>Structures</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Structures</em>'.
	 * @generated
	 */
	Structures createStructures();

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
	 * Returns a new object of class '<em>Data Provider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Provider</em>'.
	 * @generated
	 */
	<T extends Structure> DataProvider<T> createDataProvider();

	/**
	 * Returns a new object of class '<em>Indexed Data Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Indexed Data Description</em>'.
	 * @generated
	 */
	<T extends Structure> IndexedDataDescription<T> createIndexedDataDescription();

	/**
	 * Returns a new object of class '<em>Renderable Data Source</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Renderable Data Source</em>'.
	 * @generated
	 */
	<T extends Structure> RenderableDataSource<T> createRenderableDataSource();

	/**
	 * Returns a new object of class '<em>Descriptors Provider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Descriptors Provider</em>'.
	 * @generated
	 */
	DescriptorsProvider createDescriptorsProvider();

	/**
	 * Returns a new object of class '<em>Data Descriptors Provider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Descriptors Provider</em>'.
	 * @generated
	 */
	DataDescriptorsProvider createDataDescriptorsProvider();

	/**
	 * Returns a new object of class '<em>Data Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Descriptor</em>'.
	 * @generated
	 */
	DataDescriptor createDataDescriptor();

	/**
	 * Returns a new object of class '<em>Resource Descriptor Provider Pkg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Descriptor Provider Pkg</em>'.
	 * @generated
	 */
	ResourceDescriptorProviderPkg createResourceDescriptorProviderPkg();

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
	 * Returns a new object of class '<em>Physical Entity Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Physical Entity Variable</em>'.
	 * @generated
	 */
	PhysicalEntityVariable createPhysicalEntityVariable();

	/**
	 * Returns a new object of class '<em>Camera</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Camera</em>'.
	 * @generated
	 */
	Camera createCamera();

	/**
	 * Returns a new object of class '<em>Camera Matrix</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Camera Matrix</em>'.
	 * @generated
	 */
	CameraMatrix createCameraMatrix();

	/**
	 * Returns a new object of class '<em>Camera Position</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Camera Position</em>'.
	 * @generated
	 */
	CameraPosition createCameraPosition();

	/**
	 * Returns a new object of class '<em>Camera Screen World Position</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Camera Screen World Position</em>'.
	 * @generated
	 */
	CameraScreenWorldPosition createCameraScreenWorldPosition();

	/**
	 * Returns a new object of class '<em>Camera Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Camera Variable</em>'.
	 * @generated
	 */
	CameraVariable createCameraVariable();

	/**
	 * Returns a new object of class '<em>Mouse Pick Constants</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mouse Pick Constants</em>'.
	 * @generated
	 */
	MousePickConstants createMousePickConstants();

	/**
	 * Returns a new object of class '<em>Mouse Pick Extension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mouse Pick Extension</em>'.
	 * @generated
	 */
	MousePickExtension createMousePickExtension();

	/**
	 * Returns a new object of class '<em>Entity Resolver Pipeline</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entity Resolver Pipeline</em>'.
	 * @generated
	 */
	EntityResolverPipeline createEntityResolverPipeline();

	/**
	 * Returns a new object of class '<em>Selection Proxy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Selection Proxy</em>'.
	 * @generated
	 */
	SelectionProxy createSelectionProxy();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	RenderingPackage getRenderingPackage();

} //RenderingFactory
