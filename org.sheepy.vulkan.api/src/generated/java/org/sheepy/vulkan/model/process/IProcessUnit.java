/**
 */
package org.sheepy.vulkan.model.process;

import org.sheepy.common.model.root.LObject;

import org.sheepy.vulkan.model.enumeration.ECommandStage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IProcess Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.process.IProcessUnit#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.IProcessUnit#getStage <em>Stage</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.process.ProcessPackage#getIProcessUnit()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IProcessUnit extends LObject
{
	/**
	 * Returns the value of the '<em><b>Enabled</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled</em>' attribute.
	 * @see #setEnabled(boolean)
	 * @see org.sheepy.vulkan.model.process.ProcessPackage#getIProcessUnit_Enabled()
	 * @model default="true" unique="false"
	 * @generated
	 */
	boolean isEnabled();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.IProcessUnit#isEnabled <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled</em>' attribute.
	 * @see #isEnabled()
	 * @generated
	 */
	void setEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Stage</b></em>' attribute.
	 * The default value is <code>"Render"</code>.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.ECommandStage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.ECommandStage
	 * @see #setStage(ECommandStage)
	 * @see org.sheepy.vulkan.model.process.ProcessPackage#getIProcessUnit_Stage()
	 * @model default="Render" unique="false"
	 * @generated
	 */
	ECommandStage getStage();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.IProcessUnit#getStage <em>Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.ECommandStage
	 * @see #getStage()
	 * @generated
	 */
	void setStage(ECommandStage value);

} // IProcessUnit
