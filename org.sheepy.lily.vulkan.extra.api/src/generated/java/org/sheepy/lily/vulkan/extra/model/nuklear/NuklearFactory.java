/**
 */
package org.sheepy.lily.vulkan.extra.model.nuklear;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage
 * @generated
 */
public interface NuklearFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NuklearFactory eINSTANCE = org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Push Constants</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Push Constants</em>'.
	 * @generated
	 */
	NuklearPushConstants createNuklearPushConstants();

	/**
	 * Returns a new object of class '<em>Layout Task</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Layout Task</em>'.
	 * @generated
	 */
	NuklearLayoutTask createNuklearLayoutTask();

	/**
	 * Returns a new object of class '<em>Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Context</em>'.
	 * @generated
	 */
	NuklearContext createNuklearContext();

	/**
	 * Returns a new object of class '<em>Font</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Font</em>'.
	 * @generated
	 */
	NuklearFont createNuklearFont();

	/**
	 * Returns a new object of class '<em>Selector Panel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Selector Panel</em>'.
	 * @generated
	 */
	SelectorPanel createSelectorPanel();

	/**
	 * Returns a new object of class '<em>Panel Viewer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Panel Viewer</em>'.
	 * @generated
	 */
	PanelViewer createPanelViewer();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	NuklearPackage getNuklearPackage();

} //NuklearFactory
