/**
 */
package org.sheepy.lily.vulkan.model.binding;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer;
import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;

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
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.ConfigurePrepareComposite#getPartIndices <em>Part Indices</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.ConfigurePrepareComposite#getCompositeBuffer <em>Composite Buffer</em>}</li>
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
	 * Returns the value of the '<em><b>Part Indices</b></em>' attribute list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.binding.EContextIndex}.
	 * The literals are from the enumeration {@link org.sheepy.lily.vulkan.model.binding.EContextIndex}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part Indices</em>' attribute list.
	 * @see org.sheepy.lily.vulkan.model.binding.EContextIndex
	 * @see org.sheepy.lily.vulkan.model.binding.BindingPackage#getConfigurePrepareComposite_PartIndices()
	 * @model required="true"
	 * @generated
	 */
	EList<EContextIndex> getPartIndices();

	/**
	 * Returns the value of the '<em><b>Composite Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composite Buffer</em>' reference.
	 * @see #setCompositeBuffer(CompositeBuffer)
	 * @see org.sheepy.lily.vulkan.model.binding.BindingPackage#getConfigurePrepareComposite_CompositeBuffer()
	 * @model required="true"
	 * @generated
	 */
	CompositeBuffer getCompositeBuffer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.binding.ConfigurePrepareComposite#getCompositeBuffer <em>Composite Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composite Buffer</em>' reference.
	 * @see #getCompositeBuffer()
	 * @generated
	 */
	void setCompositeBuffer(CompositeBuffer value);

} // ConfigurePrepareComposite
