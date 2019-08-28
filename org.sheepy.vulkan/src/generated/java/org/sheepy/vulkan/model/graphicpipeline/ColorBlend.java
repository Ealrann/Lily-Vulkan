/**
 */
package org.sheepy.vulkan.model.graphicpipeline;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.vulkan.model.enumeration.ELogicOp;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Color Blend</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlend#getAttachments <em>Attachments</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlend#isLogicOpEnable <em>Logic Op Enable</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlend#getLogicOp <em>Logic Op</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlend#getBlendConstant0 <em>Blend Constant0</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlend#getBlendConstant1 <em>Blend Constant1</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlend#getBlendConstant2 <em>Blend Constant2</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlend#getBlendConstant3 <em>Blend Constant3</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getColorBlend()
 * @model
 * @extends ILilyEObject
 * @generated
 */
public interface ColorBlend extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Attachments</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attachments</em>' containment reference list.
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getColorBlend_Attachments()
	 * @model containment="true"
	 * @generated
	 */
	EList<ColorBlendAttachment> getAttachments();

	/**
	 * Returns the value of the '<em><b>Logic Op Enable</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Logic Op Enable</em>' attribute.
	 * @see #setLogicOpEnable(boolean)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getColorBlend_LogicOpEnable()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isLogicOpEnable();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlend#isLogicOpEnable <em>Logic Op Enable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Logic Op Enable</em>' attribute.
	 * @see #isLogicOpEnable()
	 * @generated
	 */
	void setLogicOpEnable(boolean value);

	/**
	 * Returns the value of the '<em><b>Logic Op</b></em>' attribute.
	 * The default value is <code>"COPY"</code>.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.ELogicOp}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Logic Op</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.ELogicOp
	 * @see #setLogicOp(ELogicOp)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getColorBlend_LogicOp()
	 * @model default="COPY" unique="false"
	 * @generated
	 */
	ELogicOp getLogicOp();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlend#getLogicOp <em>Logic Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Logic Op</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.ELogicOp
	 * @see #getLogicOp()
	 * @generated
	 */
	void setLogicOp(ELogicOp value);

	/**
	 * Returns the value of the '<em><b>Blend Constant0</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Blend Constant0</em>' attribute.
	 * @see #setBlendConstant0(int)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getColorBlend_BlendConstant0()
	 * @model default="0" unique="false"
	 * @generated
	 */
	int getBlendConstant0();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlend#getBlendConstant0 <em>Blend Constant0</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Blend Constant0</em>' attribute.
	 * @see #getBlendConstant0()
	 * @generated
	 */
	void setBlendConstant0(int value);

	/**
	 * Returns the value of the '<em><b>Blend Constant1</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Blend Constant1</em>' attribute.
	 * @see #setBlendConstant1(int)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getColorBlend_BlendConstant1()
	 * @model default="0" unique="false"
	 * @generated
	 */
	int getBlendConstant1();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlend#getBlendConstant1 <em>Blend Constant1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Blend Constant1</em>' attribute.
	 * @see #getBlendConstant1()
	 * @generated
	 */
	void setBlendConstant1(int value);

	/**
	 * Returns the value of the '<em><b>Blend Constant2</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Blend Constant2</em>' attribute.
	 * @see #setBlendConstant2(int)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getColorBlend_BlendConstant2()
	 * @model default="0" unique="false"
	 * @generated
	 */
	int getBlendConstant2();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlend#getBlendConstant2 <em>Blend Constant2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Blend Constant2</em>' attribute.
	 * @see #getBlendConstant2()
	 * @generated
	 */
	void setBlendConstant2(int value);

	/**
	 * Returns the value of the '<em><b>Blend Constant3</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Blend Constant3</em>' attribute.
	 * @see #setBlendConstant3(int)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getColorBlend_BlendConstant3()
	 * @model default="1" unique="false"
	 * @generated
	 */
	int getBlendConstant3();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlend#getBlendConstant3 <em>Blend Constant3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Blend Constant3</em>' attribute.
	 * @see #getBlendConstant3()
	 * @generated
	 */
	void setBlendConstant3(int value);

} // ColorBlend
