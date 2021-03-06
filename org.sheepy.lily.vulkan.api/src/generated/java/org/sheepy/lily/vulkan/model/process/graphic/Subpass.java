/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.core.model.application.ICompositor;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.vulkan.model.IResourceContainer;
import org.sheepy.lily.vulkan.model.process.PipelinePkg;
import org.sheepy.lily.vulkan.model.process.ProcessExtensionPkg;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subpass</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.Subpass#getAttachmentRefPkg <em>Attachment Ref Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.Subpass#getAttachmentPkg <em>Attachment Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.Subpass#getSubpassIndex <em>Subpass Index</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.Subpass#getPipelinePkg <em>Pipeline Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.Subpass#getBindPoint <em>Bind Point</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.Subpass#getCompositor <em>Compositor</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.Subpass#getWaitForStage <em>Wait For Stage</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.Subpass#getSyncStage <em>Sync Stage</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.Subpass#getFinishStage <em>Finish Stage</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.Subpass#getWaitForAccesses <em>Wait For Accesses</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.Subpass#getSyncAccesses <em>Sync Accesses</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.Subpass#getFinishAccesses <em>Finish Accesses</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.Subpass#getExtensionPkg <em>Extension Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.Subpass#isEnabled <em>Enabled</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSubpass()
 * @model
 * @generated
 */
public interface Subpass extends IResourceContainer, LNamedElement
{
	/**
	 * Returns the value of the '<em><b>Attachment Ref Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attachment Ref Pkg</em>' containment reference.
	 * @see #setAttachmentRefPkg(AttachmentRefPkg)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSubpass_AttachmentRefPkg()
	 * @model containment="true"
	 * @generated
	 */
	AttachmentRefPkg getAttachmentRefPkg();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.Subpass#getAttachmentRefPkg <em>Attachment Ref Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attachment Ref Pkg</em>' containment reference.
	 * @see #getAttachmentRefPkg()
	 * @generated
	 */
	void setAttachmentRefPkg(AttachmentRefPkg value);

	/**
	 * Returns the value of the '<em><b>Attachment Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attachment Pkg</em>' containment reference.
	 * @see #setAttachmentPkg(AttachmentPkg)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSubpass_AttachmentPkg()
	 * @model containment="true"
	 * @generated
	 */
	AttachmentPkg getAttachmentPkg();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.Subpass#getAttachmentPkg <em>Attachment Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attachment Pkg</em>' containment reference.
	 * @see #getAttachmentPkg()
	 * @generated
	 */
	void setAttachmentPkg(AttachmentPkg value);

	/**
	 * Returns the value of the '<em><b>Subpass Index</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subpass Index</em>' attribute.
	 * @see #setSubpassIndex(int)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSubpass_SubpassIndex()
	 * @model default="0" unique="false" required="true"
	 * @generated
	 */
	int getSubpassIndex();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.Subpass#getSubpassIndex <em>Subpass Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subpass Index</em>' attribute.
	 * @see #getSubpassIndex()
	 * @generated
	 */
	void setSubpassIndex(int value);

	/**
	 * Returns the value of the '<em><b>Pipeline Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pipeline Pkg</em>' containment reference.
	 * @see #setPipelinePkg(PipelinePkg)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSubpass_PipelinePkg()
	 * @model containment="true"
	 * @generated
	 */
	PipelinePkg getPipelinePkg();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.Subpass#getPipelinePkg <em>Pipeline Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pipeline Pkg</em>' containment reference.
	 * @see #getPipelinePkg()
	 * @generated
	 */
	void setPipelinePkg(PipelinePkg value);

	/**
	 * Returns the value of the '<em><b>Bind Point</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bind Point</em>' attribute.
	 * @see #setBindPoint(int)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSubpass_BindPoint()
	 * @model default="0" unique="false" required="true"
	 * @generated
	 */
	int getBindPoint();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.Subpass#getBindPoint <em>Bind Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bind Point</em>' attribute.
	 * @see #getBindPoint()
	 * @generated
	 */
	void setBindPoint(int value);

	/**
	 * Returns the value of the '<em><b>Compositor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compositor</em>' reference.
	 * @see #setCompositor(ICompositor)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSubpass_Compositor()
	 * @model
	 * @generated
	 */
	ICompositor getCompositor();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.Subpass#getCompositor <em>Compositor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compositor</em>' reference.
	 * @see #getCompositor()
	 * @generated
	 */
	void setCompositor(ICompositor value);

	/**
	 * Returns the value of the '<em><b>Wait For Stage</b></em>' attribute.
	 * The default value is <code>"BOTTOM_OF_PIPE_BIT"</code>.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EPipelineStage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wait For Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see #setWaitForStage(EPipelineStage)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSubpass_WaitForStage()
	 * @model default="BOTTOM_OF_PIPE_BIT" required="true"
	 * @generated
	 */
	EPipelineStage getWaitForStage();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.Subpass#getWaitForStage <em>Wait For Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wait For Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see #getWaitForStage()
	 * @generated
	 */
	void setWaitForStage(EPipelineStage value);

	/**
	 * Returns the value of the '<em><b>Sync Stage</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EPipelineStage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sync Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see #setSyncStage(EPipelineStage)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSubpass_SyncStage()
	 * @model required="true"
	 * @generated
	 */
	EPipelineStage getSyncStage();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.Subpass#getSyncStage <em>Sync Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sync Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see #getSyncStage()
	 * @generated
	 */
	void setSyncStage(EPipelineStage value);

	/**
	 * Returns the value of the '<em><b>Finish Stage</b></em>' attribute.
	 * The default value is <code>"BOTTOM_OF_PIPE_BIT"</code>.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EPipelineStage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Finish Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see #setFinishStage(EPipelineStage)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSubpass_FinishStage()
	 * @model default="BOTTOM_OF_PIPE_BIT" required="true"
	 * @generated
	 */
	EPipelineStage getFinishStage();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.Subpass#getFinishStage <em>Finish Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Finish Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see #getFinishStage()
	 * @generated
	 */
	void setFinishStage(EPipelineStage value);

	/**
	 * Returns the value of the '<em><b>Wait For Accesses</b></em>' attribute list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.enumeration.EAccess}.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EAccess}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wait For Accesses</em>' attribute list.
	 * @see org.sheepy.vulkan.model.enumeration.EAccess
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSubpass_WaitForAccesses()
	 * @model
	 * @generated
	 */
	EList<EAccess> getWaitForAccesses();

	/**
	 * Returns the value of the '<em><b>Sync Accesses</b></em>' attribute list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.enumeration.EAccess}.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EAccess}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sync Accesses</em>' attribute list.
	 * @see org.sheepy.vulkan.model.enumeration.EAccess
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSubpass_SyncAccesses()
	 * @model
	 * @generated
	 */
	EList<EAccess> getSyncAccesses();

	/**
	 * Returns the value of the '<em><b>Finish Accesses</b></em>' attribute list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.enumeration.EAccess}.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EAccess}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Finish Accesses</em>' attribute list.
	 * @see org.sheepy.vulkan.model.enumeration.EAccess
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSubpass_FinishAccesses()
	 * @model
	 * @generated
	 */
	EList<EAccess> getFinishAccesses();

	/**
	 * Returns the value of the '<em><b>Extension Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension Pkg</em>' containment reference.
	 * @see #setExtensionPkg(ProcessExtensionPkg)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSubpass_ExtensionPkg()
	 * @model containment="true"
	 * @generated
	 */
	ProcessExtensionPkg getExtensionPkg();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.Subpass#getExtensionPkg <em>Extension Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extension Pkg</em>' containment reference.
	 * @see #getExtensionPkg()
	 * @generated
	 */
	void setExtensionPkg(ProcessExtensionPkg value);

	/**
	 * Returns the value of the '<em><b>Enabled</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled</em>' attribute.
	 * @see #setEnabled(boolean)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSubpass_Enabled()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isEnabled();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.Subpass#isEnabled <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled</em>' attribute.
	 * @see #isEnabled()
	 * @generated
	 */
	void setEnabled(boolean value);

} // Subpass
