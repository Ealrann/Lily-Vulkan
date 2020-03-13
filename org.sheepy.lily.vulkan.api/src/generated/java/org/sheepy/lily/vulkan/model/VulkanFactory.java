/**
 */
package org.sheepy.lily.vulkan.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.vulkan.model.VulkanPackage
 * @generated
 */
public interface VulkanFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VulkanFactory eINSTANCE = org.sheepy.lily.vulkan.model.impl.VulkanFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Engine</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Engine</em>'.
	 * @generated
	 */
	VulkanEngine createVulkanEngine();

	/**
	 * Returns a new object of class '<em>Run Process</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Run Process</em>'.
	 * @generated
	 */
	RunProcess createRunProcess();

	/**
	 * Returns a new object of class '<em>Wait Process Idle</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Wait Process Idle</em>'.
	 * @generated
	 */
	WaitProcessIdle createWaitProcessIdle();

	/**
	 * Returns a new object of class '<em>Descriptor Pkg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Descriptor Pkg</em>'.
	 * @generated
	 */
	DescriptorPkg createDescriptorPkg();

	/**
	 * Returns a new object of class '<em>Mouse Location</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mouse Location</em>'.
	 * @generated
	 */
	MouseLocation createMouseLocation();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	VulkanPackage getVulkanPackage();

} //VulkanFactory
