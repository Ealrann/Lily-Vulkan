/**
 */
package org.sheepy.vulkan.gameoflife.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.vulkan.gameoflife.model.VulkanPackage
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
	VulkanFactory eINSTANCE = org.sheepy.vulkan.gameoflife.model.impl.VulkanFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Board Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Board Buffer</em>'.
	 * @generated
	 */
	BoardBuffer createBoardBuffer();

	/**
	 * Returns a new object of class '<em>Board Image</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Board Image</em>'.
	 * @generated
	 */
	BoardImage createBoardImage();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	VulkanPackage getVulkanPackage();

} //VulkanFactory
