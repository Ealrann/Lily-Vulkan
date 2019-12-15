/**
 */
package org.sheepy.lily.vulkan.model.binding;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.vulkan.model.binding.BindingPackage
 * @generated
 */
public interface BindingFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BindingFactory eINSTANCE = org.sheepy.lily.vulkan.model.binding.impl.BindingFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Configuration</em>'.
	 * @generated
	 */
	BindingConfiguration createBindingConfiguration();

	/**
	 * Returns a new object of class '<em>Configure Bind</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Configure Bind</em>'.
	 * @generated
	 */
	ConfigureBind createConfigureBind();

	/**
	 * Returns a new object of class '<em>Rotate Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rotate Configuration</em>'.
	 * @generated
	 */
	RotateConfiguration createRotateConfiguration();

	/**
	 * Returns a new object of class '<em>Configure Prepare Composite</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Configure Prepare Composite</em>'.
	 * @generated
	 */
	ConfigurePrepareComposite createConfigurePrepareComposite();

	/**
	 * Returns a new object of class '<em>Configure Composite Buffer Barrier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Configure Composite Buffer Barrier</em>'.
	 * @generated
	 */
	ConfigureCompositeBufferBarrier createConfigureCompositeBufferBarrier();

	/**
	 * Returns a new object of class '<em>Index Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Index Configuration</em>'.
	 * @generated
	 */
	IndexConfiguration createIndexConfiguration();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	BindingPackage getBindingPackage();

} //BindingFactory
