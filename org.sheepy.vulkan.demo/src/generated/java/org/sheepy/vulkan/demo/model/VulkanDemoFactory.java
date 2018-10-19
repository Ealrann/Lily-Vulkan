/**
 */
package org.sheepy.vulkan.demo.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.vulkan.demo.model.VulkanDemoPackage
 * @generated
 */
public interface VulkanDemoFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VulkanDemoFactory eINSTANCE = org.sheepy.vulkan.demo.model.impl.VulkanDemoFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Mesh Pipeline</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mesh Pipeline</em>'.
	 * @generated
	 */
	MeshPipeline createMeshPipeline();

	/**
	 * Returns a new object of class '<em>Mesh Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mesh Buffer</em>'.
	 * @generated
	 */
	MeshBuffer createMeshBuffer();

	/**
	 * Returns a new object of class '<em>Uniform Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Uniform Buffer</em>'.
	 * @generated
	 */
	UniformBuffer createUniformBuffer();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	VulkanDemoPackage getVulkanDemoPackage();

} //VulkanDemoFactory
