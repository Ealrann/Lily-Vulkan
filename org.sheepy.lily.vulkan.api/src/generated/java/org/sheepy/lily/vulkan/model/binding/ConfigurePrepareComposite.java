/**
 */
package org.sheepy.lily.vulkan.model.binding;

import org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configure Prepare Composite</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.ConfigurePrepareComposite#getPrepareTask <em>Prepare Task</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.ConfigurePrepareComposite#getTargetInstance <em>Target Instance</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.binding.BindingPackage#getConfigurePrepareComposite()
 * @model
 * @generated
 */
public interface ConfigurePrepareComposite extends IConfigurationTask
{
	/**
	 * Returns the value of the '<em><b>Prepare Task</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prepare Task</em>' reference.
	 * @see #setPrepareTask(PrepareCompositeTransfer)
	 * @see org.sheepy.lily.vulkan.model.binding.BindingPackage#getConfigurePrepareComposite_PrepareTask()
	 * @model required="true"
	 * @generated
	 */
	PrepareCompositeTransfer getPrepareTask();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.binding.ConfigurePrepareComposite#getPrepareTask <em>Prepare Task</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prepare Task</em>' reference.
	 * @see #getPrepareTask()
	 * @generated
	 */
	void setPrepareTask(PrepareCompositeTransfer value);

	/**
	 * Returns the value of the '<em><b>Target Instance</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.lily.vulkan.model.binding.EInstance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Instance</em>' attribute.
	 * @see org.sheepy.lily.vulkan.model.binding.EInstance
	 * @see #setTargetInstance(EInstance)
	 * @see org.sheepy.lily.vulkan.model.binding.BindingPackage#getConfigurePrepareComposite_TargetInstance()
	 * @model required="true"
	 * @generated
	 */
	EInstance getTargetInstance();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.binding.ConfigurePrepareComposite#getTargetInstance <em>Target Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Instance</em>' attribute.
	 * @see org.sheepy.lily.vulkan.model.binding.EInstance
	 * @see #getTargetInstance()
	 * @generated
	 */
	void setTargetInstance(EInstance value);

} // ConfigurePrepareComposite
